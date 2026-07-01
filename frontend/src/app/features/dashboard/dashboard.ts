import { ChangeDetectionStrategy, Component } from '@angular/core';

import { PageHeaderComponent } from '../../shared/ui/page-header/page-header';
import { StatCardComponent } from '../../shared/ui/stat-card/stat-card';
import { SectionCardComponent } from '../../shared/ui/section-card/section-card';
import { EmptyStateComponent } from '../../shared/ui/empty-state/empty-state';

import { PageHeaderModel } from '../../shared/models/page-header.model';
import { StatCardModel } from '../../shared/models/stat-card.model';

import { DataTableComponent } from '../../shared/ui/data-table/data-table';
import { DataTableModel } from '../../shared/models/data-table.model';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    PageHeaderComponent,
    StatCardComponent,
    SectionCardComponent,
    EmptyStateComponent,
    DataTableComponent,
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class DashboardComponent {
  protected readonly header: PageHeaderModel = {
    title: 'Dashboard',

    subtitle: 'Monitor project performance',

    actions: [
      {
        label: 'New Project',
        icon: 'add',
        action: () => console.log('Create Project'),
      },
    ],
  };

  protected readonly metrics: StatCardModel[] = [
    {
      title: 'Projects',
      value: 12,
      icon: 'folder',
      trend: 12,
      trendLabel: 'vs last month',
    },

    {
      title: 'Activities',
      value: 84,
      icon: 'task_alt',
      trend: 8,
      trendLabel: 'completed',
    },

    {
      title: 'SPI',
      value: '1.08',
      icon: 'speed',
      trend: 5,
      trendLabel: 'schedule',
    },

    {
      title: 'CPI',
      value: '0.96',
      icon: 'payments',
      trend: -2,
      trendLabel: 'cost',
    },
  ];

  protected readonly recentProjects: DataTableModel = {
    columns: [
      {
        field: 'name',
        header: 'Project',
      },

      {
        field: 'progress',
        header: 'Progress',
        type: 'progress',
      },

      {
        field: 'status',
        header: 'Status',
        type: 'status',
      },

      {
        field: 'manager',
        header: 'Manager',
        type: 'avatar',
      },
    ],

    data: [
      {
        name: 'ERP Migration',

        progress: {
          value: 82,
        },

        status: {
          label: 'On Track',

          color: 'success',
        },

        manager: {
          name: 'John Doe',
        },
      },

      {
        name: 'CRM Upgrade',

        progress: {
          value: 61,
        },

        status: {
          label: 'At Risk',

          color: 'warning',
        },

        manager: {
          name: 'Jane Smith',
        },
      },

      {
        name: 'Warehouse App',

        progress: {
          value: 100,
        },

        status: {
          label: 'Completed',

          color: 'success',
        },

        manager: {
          name: 'Robert Brown',
        },
      },
    ],
  };

  protected readonly quickActions = [
    {
      icon: 'add_circle',
      title: 'New Project',
      description: 'Create a new project',
    },

    {
      icon: 'task_alt',
      title: 'Register Activity',
      description: 'Add project progress',
    },

    {
      icon: 'analytics',
      title: 'View Metrics',
      description: 'Review project KPIs',
    },

    {
      icon: 'group',
      title: 'Manage Users',
      description: 'Administration',
    },
  ];
}
