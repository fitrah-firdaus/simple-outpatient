/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author fef339
 */
@Entity
@Table(name = "recipe_details", catalog = "outpatient", schema = "")
@NamedQueries({
    @NamedQuery(name = "RecipeDetails.findAll", query = "SELECT r FROM RecipeDetails r")})
public class RecipeDetails extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recipe_details_id", nullable = false)
    private Integer recipeDetailsId;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String rule;
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id", nullable = false)
    @ManyToOne(optional = false)
    private Medicine medicineId;
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id", nullable = false)
    @ManyToOne(optional = false)
    private Recipe recipeId;

    public RecipeDetails() {
    }

    public RecipeDetails(Integer recipeDetailsId) {
        this.recipeDetailsId = recipeDetailsId;
    }

    public RecipeDetails(Integer recipeDetailsId, String rule, Date dateCreated, boolean isDeleted) {
        this.recipeDetailsId = recipeDetailsId;
        this.rule = rule;
        this.dateCreated = dateCreated;
        this.isDeleted = isDeleted;
    }

    public Integer getRecipeDetailsId() {
        return recipeDetailsId;
    }

    public void setRecipeDetailsId(Integer recipeDetailsId) {
        this.recipeDetailsId = recipeDetailsId;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    public Recipe getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Recipe recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeDetailsId != null ? recipeDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeDetails)) {
            return false;
        }
        RecipeDetails other = (RecipeDetails) object;
        return !((this.recipeDetailsId == null && other.recipeDetailsId != null) || (this.recipeDetailsId != null && !this.recipeDetailsId.equals(other.recipeDetailsId)));
    }

    @Override
    public String toString() {
        return "org.simple.clinic.outpatient.model.RecipeDetails[ recipeDetailsId=" + recipeDetailsId + " ]";
    }
    
}
