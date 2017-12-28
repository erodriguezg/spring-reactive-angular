import {Perfil} from '../domain/perfil';

export class UsuarioFiltroDto {
    nombres: string;
    apellidos: string;
    rut: number;
    perfil: Perfil;
    email: string;
    fechaNacimientoInferior: Date;
    fechaNacimientoSuperior: Date;
    habilitado: boolean;
}
