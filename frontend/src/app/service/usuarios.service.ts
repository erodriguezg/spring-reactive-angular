import {Injectable} from '@angular/core';
import {ApiHttp} from '../http/api-http';
import {Usuario} from '../domain/usuario';
import {UsuarioFiltroDto} from '../dto/usuario-filtro.dto';

import {Observable} from 'rxjs/Rx';

@Injectable()
export class UsuariosService {

    constructor(private http: ApiHttp) { }

    buscar(filtros: UsuarioFiltroDto): Observable<Usuario[]> {
        return this.http.post('usuarios/buscar', JSON.stringify(filtros))
                        .map(res => <Usuario[]>res.json());
    }
}
