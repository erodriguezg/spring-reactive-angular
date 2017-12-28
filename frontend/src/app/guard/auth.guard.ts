import {Injectable} from '@angular/core';
import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {LoginService} from '../service/login.service';

@Injectable()
export class AuthGuard implements CanActivate {
    private cambiarContraseniaUrl: string;
    constructor(private loginService: LoginService, private router: Router) {
        this.cambiarContraseniaUrl = '/cambiar-contrasenia';
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        if (this.loginService.isLogged()) {
            if (!this.loginService.isNew()) {
                return true;
            } else {
                if (state.url === this.cambiarContraseniaUrl) {
                    return true;
                } else {
                    this.router.navigate([this.cambiarContraseniaUrl]);
                    return false;
                }
            }
        } else {
            this.router.navigate(['/']);
            return false;
        }
    }
}
