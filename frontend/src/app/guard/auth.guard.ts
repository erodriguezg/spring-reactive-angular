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
                return true;
        } else {
            this.router.navigate(['/']);
            return false;
        }
    }
}
