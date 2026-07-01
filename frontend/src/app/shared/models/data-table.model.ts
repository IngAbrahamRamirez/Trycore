import { AvatarModel } from '../ui/avatar/avatar.model';
import { ProgressBarModel } from '../ui/progress-bar/progress-bar.model';
import { StatusChipModel } from '../ui/status-chip/status-chip.model';

export type DataTableColumnType =
    | 'text'
    | 'status'
    | 'progress'
    | 'avatar';

export interface DataTableColumn {

    field: string;

    header: string;

    type?: DataTableColumnType;

}

export interface DataTableModel {

    columns: DataTableColumn[];

    data: Record<string, unknown>[];

}

export type DataTableCell =
    | string
    | number
    | boolean
    | StatusChipModel
    | ProgressBarModel
    | AvatarModel;