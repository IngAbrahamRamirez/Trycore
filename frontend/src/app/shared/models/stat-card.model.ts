export interface StatCardModel {

    title: string;

    value: string | number;

    icon: string;

    trend?: number;

    trendLabel?: string;

    label?: string;

    color?: 'primary' | 'success' | 'warning' | 'error';

}