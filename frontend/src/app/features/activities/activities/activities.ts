import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({

selector:'app-activities-page',

standalone:true,

template:'<h1>Activities</h1>',

changeDetection:ChangeDetectionStrategy.OnPush

})

export class ActivitiesPage{}