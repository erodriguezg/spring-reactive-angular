import {PerfilDto} from './perfil.dto';

export class UsuarioFiltroDto {
    run: number;
    nombres: string;
    apPaterno: string;
    apMaterno: string;
    email: string;
    fechaNacimientoInferior: Date;
    fechaNacimientoSuperior: Date;
    habilitado: boolean;
    perfil: PerfilDto;
}
