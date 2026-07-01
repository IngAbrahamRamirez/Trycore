import {
    ChangeDetectionStrategy,
    Component,
    computed,
    input
} from '@angular/core';

import { MetricTrendModel } from './metric-trend.model';

@Component({

    selector: 'app-metric-trend',

    standalone: true,

    templateUrl: './metric-trend.html',

    styleUrl: './metric-trend.scss',

    changeDetection: ChangeDetectionStrategy.OnPush

})

export class MetricTrendComponent {

    readonly model = input.required<MetricTrendModel>();

    readonly direction = computed(() => {

        if (this.model().value > 0) return 'up';

        if (this.model().value < 0) return 'down';

        return 'neutral';

    });

    readonly absoluteValue = computed(() => Math.abs(this.model().value));

}