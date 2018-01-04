import { AdministracionDto } from './administracion.dto';

export interface MiComunidadItemDto {
    nombre: string;
    rol: string;
    direccion: string;
    idComuna: number;
    administracionList: AdministracionDto[];
}

