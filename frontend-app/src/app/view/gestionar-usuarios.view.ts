import {Component, OnInit, ViewEncapsulation} from '@angular/core';

import {Usuario} from '../domain/usuario';
import {UsuarioFiltroDto} from '../dto/usuario-filtro.dto';
import {UsuariosService} from '../service/usuarios.service';

@Component({
    templateUrl: 'gestionar-usuarios.view.html'
})
// tslint:disable-next-line:component-class-suffix
export class GestionarUsuariosView implements OnInit {

    public usuarios: Usuario[];
    private filtros: UsuarioFiltroDto;

    constructor(private usuarioService: UsuariosService) { }

    ngOnInit() {
        this.filtros = new UsuarioFiltroDto();
        this.usuarioService.buscar(this.filtros)
            .subscribe( data => this.usuarios = data);
    }
}
