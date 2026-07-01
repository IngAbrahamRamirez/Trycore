import {
    ChangeDetectionStrategy,
    Component,
    input
} from '@angular/core';

import { StatusChipModel } from './status-chip.model';

@Component({

    selector: 'app-status-chip',

    standalone: true,

    templateUrl: './status-chip.html',

    styleUrl: './status-chip.scss',

    changeDetection: ChangeDetectionStrategy.OnPush

})

export class StatusChipComponent {

    readonly model = input.required<StatusChipModel>();

}