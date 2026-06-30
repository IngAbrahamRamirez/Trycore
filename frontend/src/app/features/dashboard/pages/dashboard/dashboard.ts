import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({

    selector:'app-dashboard-page',

    standalone:true,

    templateUrl:'./dashboard.html',

    styleUrl:'./dashboard.scss',

    changeDetection:ChangeDetectionStrategy.OnPush

})
export class DashboardPage{}