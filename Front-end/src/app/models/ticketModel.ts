export interface Ticket {
  id?: number;
  description: string;
  dateCreation?: Date;
  etat: string;
  equipementId?: number;
  utilisateurId?: number;
  panneId?: number;
}