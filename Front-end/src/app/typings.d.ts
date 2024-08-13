
declare module 'bootstrap' {
    export class Modal {
      constructor(element: Element, options?: any);
      show(): void;
      hide(): void;
      static getInstance(element: Element): Modal | null;
    }
  }