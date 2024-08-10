export interface Ticket {
    id: number;
    description: string;
    dateCreation: Date;
    etat: string;
    utilisateurId: number;
    technicienId?: number; 
  }
  