import {Injectable} from '@angular/core';
import {ApiHttp} from '../http/api-http';
import {UsuarioFiltroDto} from '../dto/usuario-filtro.dto';

import {Observable} from 'rxjs/Rx';
import {UsuarioDto} from "../dto/usuario.dto";

@Injectable()
export class UsuariosService {

    constructor(private http: ApiHttp) { }

    buscar(filtros: UsuarioFiltroDto): Observable<UsuarioDto[]> {
        return this.http.post('usuarios/buscar', JSON.stringify(filtros))
                        .map(res => <UsuarioDto[]>res.json());
    }
}
