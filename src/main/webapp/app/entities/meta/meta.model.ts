import { IAluno } from 'app/entities/aluno/aluno.model';
import { AreaDoEnem } from 'app/entities/enumerations/area-do-enem.model';

export interface IMeta {
  id: number;
  nota?: number | null;
  materia?: keyof typeof AreaDoEnem | null;
  aluno?: Pick<IAluno, 'id'> | null;
}

export type NewMeta = Omit<IMeta, 'id'> & { id: null };
