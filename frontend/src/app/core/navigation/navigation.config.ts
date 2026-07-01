import { APP_ROUTES } from '../constants/routes';

import { NavigationItem } from './navigation-item';

export const NAVIGATION_ITEMS: NavigationItem[] = [

    {
        id:'dashboard',
        label:'Dashboard',
        icon:'dashboard',
        route:APP_ROUTES.DASHBOARD,
        exact:true
    },

    {
        id:'projects',
        label:'Projects',
        icon:'folder',
        route:APP_ROUTES.PROJECTS,
        exact:true
    },

    {
        id:'activities',
        label:'Activities',
        icon:'task',
        route:APP_ROUTES.ACTIVITIES,
        exact:true
    },

    {
        id:'metrics',
        label:'Metrics',
        icon:'analytics',
        route:APP_ROUTES.METRICS,
        exact:true
    },

    {
        id:'users',
        label:'Users',
        icon:'group',
        route:APP_ROUTES.USERS,
        exact:true
    }

];