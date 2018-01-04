import { Injectable } from '@angular/core';
import { ApiHttp } from '../http/api-http';
import { Response, URLSearchParams, Http } from '@angular/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { SessionStorage } from 'ng2-webstorage';
import { Sesion } from '../domain/sesion';
import { CredencialesDto } from '../dto/credenciales.dto';
import { RespuestaLoginDto } from '../dto/respuesta-login.dto';
import { RefreshTokenDto } from '../dto/refresh-token.dto';
import { Idle } from '@ng-idle/core';
import { ENVIRONMENT } from 'environments/environment';

@Injectable()
export class LoginService {
    @SessionStorage()
    public sesion: Sesion;

    private refreshTokenTimer;

    constructor(
        private http: ApiHttp,
        private router: Router,
        private idle: Idle,
        private httpNoIntercept: Http
    ) { }

    public login(username: string, password: string): Observable<RespuestaLoginDto> {
        const credenciales: CredencialesDto = {
            username: username,
            password: password
        };
        return this.http.post('security/login', JSON.stringify(credenciales))
            .map((res: Response) => {
                const resp: RespuestaLoginDto = res.json();

                if (resp.exitoLogin) {
                    this.procesarToken(resp.token);
                    this.idle.watch();
                }
                return resp;
            });
    }

    private procesarToken(token: string) {
        const payload = JSON.parse(atob(token.split('.')[1]));
        this.sesion = {
            token: token,
            iat: payload.iat,
            exp: payload.exp,
            jti: payload.jti,
            data: JSON.parse(payload.sub)
        };
        this.setRefreshTokenTimer();
    }

    private setRefreshTokenTimer() {
        const time: number = (this.sesion.exp - (new Date().getTime() / 1000) - ENVIRONMENT.REFRESH_TOKEN_BEFORE_EXP_TIME) * 1000;
        this.refreshTokenTimer = setTimeout(() => this.refrescarToken().subscribe(), time);
    }

    private stopRefreshTokenTimer() {
        clearTimeout(this.refreshTokenTimer);
        this.refreshTokenTimer = null;
    }

    public refrescarToken(): Observable<RefreshTokenDto> {
        if (!this.isLogged()) {
            return Observable.create(undefined);
        } else {
            return this.http.post('security/refreshToken', null)
                .map((res: Response) => {
                    const resp: RefreshTokenDto = <RefreshTokenDto>res.json();
                    this.procesarToken(resp.token);
                    return resp;
                });
        }
    }

    public logout() {
        this.sesion = null;
        this.idle.stop();
        this.stopRefreshTokenTimer();
        this.router.navigate(['/']);
    }

    public logoutNoNavigate() {
        this.sesion = null;
        this.idle.stop();
        this.stopRefreshTokenTimer();
    }

    public isLogged(): boolean {
        const logged: boolean = (this.sesion !== undefined && this.sesion !== null);
        if (logged && (this.refreshTokenTimer === undefined || this.refreshTokenTimer == null)) {
            this.setRefreshTokenTimer();
        }
        return logged;
    }

    public getFullName(): string {
        return this.sesion.data.nombres + ' ' + this.sesion.data.apellidos;
    }

}
