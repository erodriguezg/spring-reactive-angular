import {Component, OnInit} from '@angular/core';
import {LoginService} from '../service/login.service';
import {Router} from '@angular/router';

@Component({
    templateUrl: 'login.view.html'
})
// tslint:disable-next-line:component-class-suffix
export class LoginView {
    public username: string;
    public password: string;
    public msgs = [];

    constructor(private loginService: LoginService, private router: Router) {
        this.loginService.logoutNoNavigate();
    }

    public login() {
        this.loginService.login(this.username, this.password).subscribe(res => {
            if (res.exitoLogin) {
                this.router.navigate(['start']);
            } else {
                res.errores.forEach(error => {
                    this.msgs.push({severity: 'error', summary: 'Error', detail: error});
                });
            }
        });
    }
}
