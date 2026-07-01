import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({

selector:'app-metrics-page',

standalone:true,

template:'<h1>Metrics</h1>',

changeDetection:ChangeDetectionStrategy.OnPush

})

export class MetricsPage{}