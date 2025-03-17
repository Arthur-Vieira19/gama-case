import { IMeta, NewMeta } from './meta.model';

export const sampleWithRequiredData: IMeta = {
  id: 17187,
  nota: 11470,
  materia: 'CODIGOS',
};

export const sampleWithPartialData: IMeta = {
  id: 15622,
  nota: 24285,
  materia: 'CIENCIAS_HUMANAS',
};

export const sampleWithFullData: IMeta = {
  id: 32703,
  nota: 5776,
  materia: 'LINGUAGENS',
};

export const sampleWithNewData: NewMeta = {
  nota: 16271,
  materia: 'MATEMATICA',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
