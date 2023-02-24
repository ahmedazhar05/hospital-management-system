export default class Utilities {

    static formatDate(date: Date){
        return date.toLocaleString('en-US', {
            year:'numeric',
            month:'2-digit',
            day:'2-digit'
        }).split('/').reverse().join('-');
    }
}