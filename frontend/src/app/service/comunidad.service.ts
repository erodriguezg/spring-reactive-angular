import { Injectable } from '@angular/core';
import { ApiHttp } from '../http/api-http';
import { MiComunidadFiltroDto } from '../dto/mi-comunidad-filtro.dto';
import { ComunidadDto } from '../dto/comunidad.dto';
import { MiComunidadItemDto } from '../dto/mi-comunidad-item.dto';

import { Observable } from 'rxjs/Rx';

@Injectable()
export class ComunidadService {

    constructor(private http: ApiHttp) { }

    public registrarComunidad(comunidadDto: ComunidadDto): Observable<void> {
        return this.http.post('comunidad/registrar', JSON.stringify(comunidadDto))
            .map(res => { });
    }

    public traerMisComunidadesPorFiltro(filtroDto: MiComunidadFiltroDto): Observable<MiComunidadItemDto[]> {
        return this.http.post('comunidad/traermiscomunidades', JSON.stringify(filtroDto))
            .map(res => <MiComunidadItemDto[]>res.json());
    }

    public traerPorNombreComunidad(nombre: String): Observable<ComunidadDto> {
        return this.http.post('comunidad/traerpornombrecomunidad', JSON.stringify(<ComunidadDto>{ nombre: nombre }))
            .map(res => <ComunidadDto>res.json());
    }

    public validarNombreComunidad(nombre: String): Observable<void> {
        return this.http.post('comunidad/validarnombrecomunidad', JSON.stringify(<ComunidadDto>{ nombre: nombre }))
            .map(res => { });
    }

}
