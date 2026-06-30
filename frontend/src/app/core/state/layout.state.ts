import {
    Injectable,
    computed,
    signal
} from '@angular/core';

@Injectable({
    providedIn:'root'
})
export class LayoutState{

    readonly sidebarOpened = signal(true);

    readonly drawerOpened = signal(false);

    readonly sidebarWidth = computed(()=>

        this.sidebarOpened()

            ? 'var(--sidebar-width)'

            : 'var(--sidebar-collapsed-width)'

    );

    toggleSidebar(){

        this.sidebarOpened.update(v=>!v);

    }

    openDrawer(){

        this.drawerOpened.set(true);

    }

    closeDrawer(){

        this.drawerOpened.set(false);

    }

}