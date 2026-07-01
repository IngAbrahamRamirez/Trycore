import {
    ChangeDetectionStrategy,
    Component,
    computed,
    input
} from '@angular/core';

import { ProgressBarModel } from './progress-bar.model';

@Component({

    selector:'app-progress-bar',

    standalone:true,

    templateUrl:'./progress-bar.html',

    styleUrl:'./progress-bar.scss',

    changeDetection:ChangeDetectionStrategy.OnPush

})

export class ProgressBarComponent{

    readonly model=input.required<ProgressBarModel>();

    readonly width=computed(()=>{

        const value=Math.max(0,Math.min(100,this.model().value));

        return `${value}%`;

    });

}