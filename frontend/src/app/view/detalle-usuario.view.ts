import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Usuario} from '../domain/usuario';
import {UsuariosService} from '../service/usuarios.service';

const PARAM_MODO = 'modo';
const PARAM_ID_USUARIO = 'id_usuario';
const MODO_VER = 'ver';

@Component({
    templateUrl: 'detalle-usuario.view.html',
})
// tslint:disable-next-line:component-class-suffix
export class DetalleUsuarioView implements OnInit {

    private usuario: Usuario;
    private editable: boolean;
    private nuevo: boolean;

    constructor(
        private usuarioService: UsuariosService,
        private activatedRoute: ActivatedRoute,
        private router: Router,
        ) {

        }

    public ngOnInit() {
        let modo: string;
        let idUsuario: number;
        this.activatedRoute.params.forEach((params: Params) => {
            modo = params[PARAM_MODO];
            idUsuario = params[PARAM_ID_USUARIO];
        });

        this.editable = modo === MODO_VER;
        this.nuevo = idUsuario !== undefined  && idUsuario !== null;

        if (!idUsuario) {
            this.usuario = new Usuario();
        }



    }

    public guardar(): void {
       // metodo guardar
    }

    public volver(): void {
        // metodo volver
    }

}
