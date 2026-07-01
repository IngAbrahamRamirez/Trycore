import {
    ChangeDetectionStrategy,
    Component,
    computed,
    input
} from '@angular/core';

import { StatCardModel } from '../../models/stat-card.model';

@Component({

    selector: 'app-stat-card',

    standalone: true,

    templateUrl: './stat-card.html',

    styleUrl: './stat-card.scss',

    changeDetection: ChangeDetectionStrategy.OnPush

})
export class StatCardComponent {

    readonly model = input.required<StatCardModel>();

    readonly positiveTrend = computed(() => (this.model().trend ?? 0) >= 0);

    protected readonly Math = Math;

}