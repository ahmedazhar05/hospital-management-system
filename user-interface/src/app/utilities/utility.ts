export default class Utilities {

    static formatDate(date: Date){
        let parts = date.toLocaleString('en-US', {
            year:'numeric',
            month:'2-digit',
            day:'2-digit'
        }).split('/');
        return parts[2] + "-" + parts[0] + "-" + parts[1];
    }

    static calculateAge(date: Date | string){
        if(typeof(date) == 'string') date = new Date(date.slice(0, 10));
        else date = date;
        return new Date().getFullYear() - date.getFullYear();
    }
}