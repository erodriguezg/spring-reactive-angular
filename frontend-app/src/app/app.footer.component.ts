import {Component, Inject, forwardRef} from '@angular/core';
import {AppComponent} from './app.component';

@Component({
    selector: 'app-footer',
    template: `
            <div class="footer clearfix">
                <div class="container">
                    <div class="ui-g-12 ui-md-8">
                        <p>Para soporte técnico o solicitar nuevos indicadores, ingrese un ticket vía:
                            <br>
                            <a href="http://estadisticasrshayuda.ministeriodesarrollosocial.gob.cl">
                                Estadísticas RSH Ayuda - Ministerio Desarrollo Social
                            </a>
                        </p>
                    </div>
                    <div class="ui-g-12  ui-md-4">
                        <div class="ui-g-12 ui-md-6">
                            <p><strong>Ministerio de Desarrollo Social</strong>
                            <br>
                            Catedral 1575
                            <br>
                            Teléfono +56 2 2675 1400</p>
                        </div>
                        <div class="ui-g-12 ui-md-6">
                            <img src="assets/layout/images/logo.png" class="logo_footer">
                        </div>
                    </div>
                </div>
            </div>
            <scroll-top></scroll-top>
            <idle-detector></idle-detector>
            <loading-ui></loading-ui>
    `
})
export class AppFooterComponent {

}
