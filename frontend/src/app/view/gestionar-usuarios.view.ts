import {Component, OnInit, ViewEncapsulation} from '@angular/core';

import {UsuarioDto} from '../dto/usuario.dto';
import {UsuarioFiltroDto} from '../dto/usuario-filtro.dto';
import {UsuariosService} from '../service/usuarios.service';

@Component({
    templateUrl: 'gestionar-usuarios.view.html'
})
// tslint:disable-next-line:component-class-suffix
export class GestionarUsuariosView implements OnInit {

    private usuarios: UsuarioDto[];
    private filtros: UsuarioFiltroDto;

    constructor(private usuarioService: UsuariosService) { }

    ngOnInit() {
        this.filtros = new UsuarioFiltroDto();
        this.usuarioService.buscar(this.filtros)
            .subscribe( data => {
                console.log("data: " + data);
                this.usuarios = data;
            });
    }
}
