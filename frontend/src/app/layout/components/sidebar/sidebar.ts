import {
  ChangeDetectionStrategy,
  Component,
  inject
} from '@angular/core';

import {
  RouterLink,
  RouterLinkActive
} from '@angular/router';

import { NAVIGATION_ITEMS } from '../../../core/navigation/navigation.config';
import { LayoutState } from '../../../core/state/layout.state';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './sidebar.html',
  styleUrl: './sidebar.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SidebarComponent {

  protected readonly navigation = NAVIGATION_ITEMS;

  protected readonly layout = inject(LayoutState);

}