import { Injectable } from '@angular/core';
import { ApiHttp } from '../http/api-http';
import { RegionDto } from '../dto/region.dto';
import { ProvinciaDto } from '../dto/provincia.dto';
import { ComunaDto } from '../dto/comuna.dto';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class TerritorioService {

    constructor(private http: ApiHttp) { }

    public traerTodasLasRegiones(): Observable<RegionDto[]> {
        return this.http.post('territorio/traerTodasLasRegiones', null)
            .map(res => <RegionDto[]>res.json());
    }

    public traerProvinciasPorRegion(region: RegionDto): Observable<ProvinciaDto[]> {
        return this.http.post('territorio/traerProvinciasPorRegion', JSON.stringify(region))
            .map(res => <ProvinciaDto[]>res.json());
    }

    public traerComunasPorProvincia(provincia: ProvinciaDto): Observable<ComunaDto[]> {
        return this.http.post('territorio/traerComunasPorProvincia', JSON.stringify(provincia))
            .map(res => <ComunaDto[]>res.json());
    }

}
