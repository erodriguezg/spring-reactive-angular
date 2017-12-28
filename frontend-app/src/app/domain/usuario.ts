import {Perfil} from './perfil';

export class Usuario {
    rut: number;
    nombres: string;
    apellidos: string;
    password: string;
    fechaNacimiento: Date;
    email: string;
    perfil: Perfil;
    habilitado: boolean;
}
