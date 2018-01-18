import {Injectable} from '@angular/core';
import {Http, RequestOptions, RequestOptionsArgs, Request, Response, ConnectionBackend, Headers} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {Router} from '@angular/router';
import {SessionStorage} from 'ngx-webstorage';
import {ENVIRONMENT} from 'environments/environment';
import {LoadingService} from '../service/loading.service';
import {Sesion} from '../domain/sesion';

@Injectable()
export class ApiHttp extends Http {
    @SessionStorage()
    public sesion: Sesion;
    private calls = 0;
    private httpNoToken;

    constructor(
        backend: ConnectionBackend,
        defaultOptions: RequestOptions,
        private router: Router,
        private loadingService: LoadingService
        ) {
        super(backend, defaultOptions);
    }

    public getCustomRequestOptions(options?: RequestOptionsArgs) {
        let opts: RequestOptionsArgs;
        if (options !== undefined) {
            opts = options;
            if (opts.headers === undefined) {
                opts.headers = new Headers();
            }
        } else {
            opts = {headers: new Headers()};
        }
        opts.headers.append('Authorization', 'Bearer ' + ((this.sesion !== undefined && this.sesion != null) ? this.sesion.token : ''));
        opts.headers.append('Accept', 'application/json');
        opts.headers.append('Content-Type', 'application/json');
        return opts;
    }

    request(url: string | Request, options?: RequestOptionsArgs): Observable<Response> {
        const u: string = (<Request>url).url;
        (<Request>url).url = !u.startsWith(ENVIRONMENT.API_URL) ? ENVIRONMENT.API_URL + u : u;
        console.log(url);
        return this.interceptor(super.request(url, this.getCustomRequestOptions(options)))
                    .catch((error: any) => this.handleError(error));
    }

    get(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.get(url, this.getCustomRequestOptions(options))
                    .catch((error: any) => this.handleError(error));
    }

    post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        return super.post(url, body, this.getCustomRequestOptions(options))
                    .catch((error: any) => this.handleError(error));
    }

    put(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        return super.put(url, body, this.getCustomRequestOptions(options))
                    .catch((error: any) => this.handleError(error));
    }

    delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.delete(url, this.getCustomRequestOptions(options))
                    .catch((error: any) => this.handleError(error));
    }

    patch(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        return super.patch(url, body, this.getCustomRequestOptions(options))
                    .catch((error: any) => this.handleError(error));
    }

    head(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.head(url, this.getCustomRequestOptions(options))
                    .catch((error: any) => this.handleError(error));
    }

    options(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.options(url, this.getCustomRequestOptions(options))
                    .catch((error: any) => this.handleError(error));
    }

    private handleError (error: Response | any) {
        switch (error.status) {
            case 403:
            case 401:
                this.router.navigate(['/']);
                break;
        }
        let errMsg: string;
        if (error instanceof Response) {
            const body: any = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }

    private interceptor(observable: Observable<Response>): Observable<Response> {
        this.calls++;
        if (this.calls === 1) {
            this.loadingService.beginLoading.emit('beginLoadingEvent');
        }
        return observable.finally(
            () => {
                this.calls--;
                if (this.calls === 0) {
                    this.loadingService.endLoading.emit('endLoadingEvent');
                }
            }
        );
    }
}
