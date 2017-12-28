import { Component } from '@angular/core';
import { LoadingService } from '../service/loading.service';

@Component({
    selector: 'loading-ui',
    template:
    `
        <div class="loading-ui" *ngIf="isLoading">
            <div class="ui-growl ui-widget">
                    <div class="ui-growl-item-container"> 
                        <div class="ui-growl-item"> 
                            <div class="ui-g">
                                <div class="ui-g-2">
                                    <div class="sk-cube-grid">
                                        <div class="sk-cube sk-cube1"></div>
                                        <div class="sk-cube sk-cube2"></div>
                                        <div class="sk-cube sk-cube3"></div>
                                        <div class="sk-cube sk-cube4"></div>
                                        <div class="sk-cube sk-cube5"></div>
                                        <div class="sk-cube sk-cube6"></div>
                                        <div class="sk-cube sk-cube7"></div>
                                        <div class="sk-cube sk-cube8"></div>
                                        <div class="sk-cube sk-cube9"></div>
                                    </div>
                                </div>

                                <div class="ui-g-10">
                                    <div class="ui-growl-message" style="margin-left: 25px">
                                        <label class="ui-growl-title">Cargando Datos</label>
                                        <p>Por favor, espere unos momentos.</p>
                                    </div>
                                </div>
                            </div>
                            
                            <div style="clear: both;"></div>
                        </div>
                    </div>
                </div>
            </div>
    `
})

export class LoadingUIComponent {
    isLoading = false;
    loadingService: LoadingService;
    private differ: any;

    constructor(loading: LoadingService) {
        this.loadingService = loading;
        this.loadingService.beginLoading.subscribe(this.beginLoadingCallback.bind(this));
        this.loadingService.endLoading.subscribe(this.endLoadingCallback.bind(this));
    }

    private beginLoadingCallback() {
        this.isLoading = true;
    }
    private endLoadingCallback() {
        this.isLoading = false;
    }
}
