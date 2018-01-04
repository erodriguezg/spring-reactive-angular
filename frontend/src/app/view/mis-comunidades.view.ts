import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Message } from 'primeng/primeng';
import { ComunidadService } from '../service/comunidad.service';
import { MiComunidadFiltroDto } from '../dto/mi-comunidad-filtro.dto';
import { MiComunidadItemDto } from '../dto/mi-comunidad-item.dto';
import * as _ from 'lodash';

@Component({
    templateUrl: 'mis-comunidades.view.html'
})
// tslint:disable-next-line:component-class-suffix
export class MisComunidadesView implements OnInit {

    private msgs: Message[] = [];

    private comunidadesList: MiComunidadItemDto[];

    private filtro: MiComunidadFiltroDto;

    private filtroTimeout: NodeJS.Timer;

    constructor(private comunidadService: ComunidadService) { };

    public ngOnInit() {
        this.filtro = <MiComunidadFiltroDto>{ nombreComunidad: null };
        this.comunidadesList = [];
        this.comunidadService.traerMisComunidadesPorFiltro(this.filtro)
            .subscribe(data => this.comunidadesList = data );
    }

    public entrar(comunidad: MiComunidadItemDto): void {
        console.log('entro ' + JSON.stringify(comunidad));
    }

    public buscar(): void {
        clearTimeout(this.filtroTimeout);
        this.filtroTimeout = setTimeout(() => {
            this.comunidadService.traerMisComunidadesPorFiltro(this.filtro)
                        .subscribe(data => this.comunidadesList = data);
        }, 600);
    }

}
