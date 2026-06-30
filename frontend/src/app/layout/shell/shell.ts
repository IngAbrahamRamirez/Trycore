import {
    ChangeDetectionStrategy,
    Component,
    inject
} from '@angular/core';

import { RouterOutlet } from '@angular/router';

import { SidebarComponent } from '../components/sidebar/sidebar';
import { ToolbarComponent } from '../components/toolbar/toolbar';
import { FooterComponent } from '../components/footer/footer';

import { LayoutState } from '../../core/state/layout.state';

@Component({

    selector:'app-shell',

    standalone:true,

    imports:[
        RouterOutlet,
        SidebarComponent,
        ToolbarComponent,
        FooterComponent
    ],

    templateUrl:'./shell.html',

    styleUrl:'./shell.scss',

    changeDetection:ChangeDetectionStrategy.OnPush

})
export class ShellComponent{

    protected readonly layout=inject(LayoutState);

}