export interface StatCardModel {

    title: string;

    value: string | number;

    icon: string;

    trend?: number;

    trendLabel?: string;

    color?: 'primary' | 'success' | 'warning' | 'error';

}