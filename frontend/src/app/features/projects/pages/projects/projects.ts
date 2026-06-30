import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({

    selector:'app-projects-page',

    standalone:true,

    template:'<h1>Projects</h1>',

    changeDetection:ChangeDetectionStrategy.OnPush

})
export class ProjectsPage{}