from django.db import models

# Create your models here.

class Faculty(models.Model):
    name = models.CharField(max_length=50)

class Student(models.Model):
    std_id = models.CharField(max_length=12, unique=True)
    name = models.CharField(max_length=50)
    faculty = models.ForeignKey(Faculty, related_name='students',
                                        on_delete=models.CASCADE)
