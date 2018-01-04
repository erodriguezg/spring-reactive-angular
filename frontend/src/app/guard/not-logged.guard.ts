import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {LoginService} from '../service/login.service';

@Injectable()
export class NotLoggedGuard implements CanActivate {
    constructor(private loginService: LoginService, private router: Router) { }

    canActivate() {
        if (!this.loginService.isLogged()) {
            return true;
        } else {
            this.router.navigate(['start']);
            return false;
        }
    }
}
