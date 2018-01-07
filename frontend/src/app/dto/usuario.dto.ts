import {PerfilDto} from './perfil.dto';
import {PersonaDto} from "./persona.dto";

export class UsuarioDto {
    username: string;
    habilitado: boolean;
    password: string;
    perfil: PerfilDto;
    persona: PersonaDto;
}
