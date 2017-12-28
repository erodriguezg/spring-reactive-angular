import { Component, ElementRef } from '@angular/core';
import {Idle, DEFAULT_INTERRUPTSOURCES} from '@ng-idle/core';
import {ENVIRONMENT} from 'environments/environment';
import {LoginService} from '../service/login.service';

@Component({
    selector: 'idle-detector',
    template:
    `
        <p-dialog header="Inactivo" [(visible)]="display" [draggable]="false" [closable]="false" 
            [resizable]="false" [closeOnEscape]="true" modal="modal" width="300" responsive="true">
            <p *ngIf="countdown">Su sesión expirará por inactivad en {{countdown}} segundos</p>
            <p *ngIf="!countdown">Su sesión ha expirado</p>
            <footer *ngIf="timeout">
                <div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
                    <button type="button" pButton icon="fa-check" (click)="expired()" label="Ok"></button>
                </div>
            </footer>
        </p-dialog>
    `
})
export class IdleDetectorComponent {
    public display: boolean;
    public countdown: number;
    public timeout: boolean;

    constructor(private idle: Idle, private loginService: LoginService) {
        this.display = false;
        this.timeout = false;
        this.idle.setIdle(ENVIRONMENT.IDLE_TIME);
        this.idle.setTimeout(ENVIRONMENT.IDLE_TIMEOUT_TIME);
        this.idle.setInterrupts(DEFAULT_INTERRUPTSOURCES);

        this.idle.onIdleEnd.subscribe(() => this.display = false);
        this.idle.onTimeoutWarning.subscribe((countdown) => {
            this.display = true;
            this.countdown = countdown;
        });
        this.idle.onTimeout.subscribe(() => {
            this.countdown = undefined;
            this.timeout = true;
            this.loginService.sesion = null;
        });
        if (this.loginService.isLogged()) {
            this.idle.watch();
        }
    }

    private expired() {
        this.loginService.logout();
        this.display = false;
    }
}
