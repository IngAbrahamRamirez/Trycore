export interface PageHeaderAction {

    label: string;

    icon?: string;

    color?: 'primary' | 'secondary';

    disabled?: boolean;

    action: () => void;

}

export interface PageHeaderModel {

    title: string;

    subtitle?: string;

    actions?: PageHeaderAction[];

}