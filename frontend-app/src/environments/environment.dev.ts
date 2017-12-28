import * as _ from 'lodash';
import {environmentCommons} from './environment.commons';
import {EnvironmentType} from './environment-type';

const environmentType: EnvironmentType = {
    production: false,
    ENV_NAME: 'dev',
    API_URL: 'http://localhost:8080/'
};

export const ENVIRONMENT = _.merge(environmentCommons, environmentType);
