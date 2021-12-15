import {class2} from './class2.js';

export class class1 {
    
    publicMethod() {
        return 'publicMethod() dans class1';
    }
    
    publicMethodFromClass2() {
        const c2 = new class2();
        return c2.publicMethod();
    }
    
} // end class

