import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

// Navigation Guards
import { AuthGuard } from './guard/auth.guard';
import { NotLoggedGuard } from './guard/not-logged.guard';

// Vistas
import { LoginView } from './view/login.view';
import { StartView } from './view/start.view';
import { GestionarUsuariosView } from './view/gestionar-usuarios.view';

export const routes: Routes = [
    { path: '', component: LoginView, canActivate: [NotLoggedGuard] },
    { path: 'start', component: StartView, canActivate: [AuthGuard] },
    { path: 'gestionar-usuarios', component: GestionarUsuariosView, canActivate: [AuthGuard] },
    { path: '**', redirectTo: '' }
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
