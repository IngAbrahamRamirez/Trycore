export type StatusChipType =
    | 'success'
    | 'warning'
    | 'danger'
    | 'info'
    | 'neutral';

export interface StatusChipModel {

    label: string;

    type: StatusChipType;

}