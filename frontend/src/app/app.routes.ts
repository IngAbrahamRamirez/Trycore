import { Routes } from '@angular/router';

import { ShellComponent } from './layout/shell/shell';

export const routes: Routes = [

  {
    path: '',
    component: ShellComponent,
    children: [

      {
        path: '',
        loadChildren: () =>
          import('./features/dashboard/dashboard.routes')
            .then(m => m.DASHBOARD_ROUTES)
      },

      {
        path: 'projects',
        loadChildren: () =>
          import('./features/projects/projects.routes')
            .then(m => m.PROJECTS_ROUTES)
      },

      {
        path: 'activities',
        loadChildren: () =>
          import('./features/activities/activities.routes')
            .then(m => m.ACTIVITIES_ROUTES)
      },

      {
        path: 'metrics',
        loadChildren: () =>
          import('./features/metrics/metrics.routes')
            .then(m => m.METRICS_ROUTES)
      },

      {
        path: 'users',
        loadChildren: () =>
          import('./features/users/users.routes')
            .then(m => m.USERS_ROUTES)
      }

    ]

  },

  {

    path: '**',

    redirectTo: ''

  }

];