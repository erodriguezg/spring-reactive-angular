import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, Validators, FormControl, FormGroup, AsyncValidatorFn, AbstractControl } from '@angular/forms';

import { SelectItem, ConfirmDialogModule, ConfirmationService, Message } from 'primeng/primeng';

import { RegionDto } from '../dto/region.dto';
import { ProvinciaDto } from '../dto/provincia.dto';
import { ComunaDto } from '../dto/comuna.dto';
import { ComunidadDto } from '../dto/comunidad.dto';

import { TerritorioService } from '../service/territorio.service';
import { ComunidadService } from '../service/comunidad.service';

import * as _ from 'lodash';

@Component({
    templateUrl: 'registrar-comunidad.view.html'
})
// tslint:disable-next-line:component-class-suffix
export class RegistrarComunidadView implements OnInit {

    private msgs: Message[] = [];

    private regionSelectItems: SelectItem[];

    private provinciaSelectItems: SelectItem[];

    private comunaSelectItems: SelectItem[];

    private comunidadForm: FormGroup;

    private submitted: boolean;

    private nombreUnicoValidationTimeout: NodeJS.Timer;

    constructor(private territorioService: TerritorioService,
        private comunidadService: ComunidadService,
        private confirmationService: ConfirmationService,
        private _fb: FormBuilder) { };

    public ngOnInit() {
        this.submitted = false;
        this.crearFormulario();
        this.territorioService.traerTodasLasRegiones()
            .subscribe(regiones => {
                this.regionSelectItems = _.concat([{ label: 'Seleccionar', value: null }],
                    _.map(regiones, this.regionToSelectItem));
                this.comunidadForm.patchValue({ regionDto: null });
                this.comunidadForm.patchValue({ provinciaDto: null });
                this.comunidadForm.patchValue({ comunaDto: null });
            });
    }

    private crearFormulario(): void {
        this.comunidadForm = this._fb.group({
            nombre: ['', Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(100)]),
                this.nombreComunidadUnicoValidator()],
            rol: ['', Validators.compose([Validators.required, Validators.minLength(4), Validators.maxLength(10)])],
            direccion: ['', Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(100)])],
            regionDto: [null, Validators.required],
            provinciaDto: [null, Validators.required],
            comunaDto: [null, Validators.required]
        });
    }

    private regionToSelectItem(region: RegionDto): SelectItem {
        return <SelectItem>{ label: region.nombreRegion, value: region };
    }

    public changeRegionListener(): void {
        const regionSelected: RegionDto = this.comunidadForm.controls['regionDto'].value;
        console.log('región seleccionada es: ' + JSON.stringify(regionSelected));
        this.territorioService.traerProvinciasPorRegion(regionSelected)
            .subscribe(provinciasList => {
                this.provinciaSelectItems = _.concat([{ label: 'Seleccionar', value: null }],
                    _.map(provinciasList, this.provinciaToSelectItem));
                this.comunidadForm.patchValue({ provinciaDto: null });
                this.comunidadForm.patchValue({ comunaDto: null });
            });
    }

    private provinciaToSelectItem(provincia: ProvinciaDto): SelectItem {
        return <SelectItem>{ label: provincia.nombreProvincia, value: provincia };
    }

    public changeProvinciaListener(): void {
        const provinciaSelected: ProvinciaDto = this.comunidadForm.controls['provinciaDto'].value;
        console.log('provincia seleccionada es: ' + JSON.stringify(provinciaSelected));
        this.territorioService.traerComunasPorProvincia(provinciaSelected)
            .subscribe(comunasList => {
                this.comunaSelectItems = _.concat([{ label: 'Seleccionar', value: null }],
                    _.map(comunasList, this.comunaToSelectItem));
                this.comunidadForm.patchValue({ comunaDto: null });
            });
    }

    private comunaToSelectItem(comuna: ComunaDto): SelectItem {
        return <SelectItem>{ label: comuna.nombreComuna, value: comuna };
    }

    public confirmRegistrar(): void {
        this.confirmationService.confirm({
            message: 'Esta seguro que desea crear la comunidad?',
            accept: () => {
                this.registrar();
            }
        });
    }

    public registrar(): void {
        this.submitted = true;
        if (!this.comunidadForm.valid) {
            return;
        }
        const registroDto: ComunidadDto = this.comunidadForm.value;
        console.log('registrar: ' + JSON.stringify(registroDto));
        this.comunidadService.registrarComunidad(registroDto)
            .subscribe(() => {
                this.msgs.push({ severity: 'success', summary: 'Success Message', detail: 'Comunidad Registrada' });
            }, error => {
                this.msgs.push({ severity: 'error', summary: 'Error Message', detail: error });
            });
    }

    public cancel(): void {
        console.log('cancel!');
        this.msgs.push({ severity: 'info', summary: 'Error Message', detail: 'cancelado' });
    }

    private nombreComunidadUnicoValidator(): AsyncValidatorFn {
        return (control: AbstractControl): Promise<any> => {
            clearTimeout(this.nombreUnicoValidationTimeout);
            return new Promise<any>(resolve => {
                this.nombreUnicoValidationTimeout = setTimeout(() => {
                    this.comunidadService.validarNombreComunidad(control.value)
                        .subscribe(() => resolve(null), error => resolve({ nombreUnico: true }));
                }, 1000);
            });
        };
    };

}
