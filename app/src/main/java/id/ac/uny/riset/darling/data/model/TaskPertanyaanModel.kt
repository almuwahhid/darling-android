package id.ac.uny.riset.darling.data.model

data class TaskPertanyaanModel (var id_task_pertanyaan: String,
                                var id_pertanyaan_survey: String,
                                var tanggal_task: String,
                                var intervensi_task: String,
                                var status_task: String,
                                var tanggal_submit: String,
                                var komentar_pertanyaan: String = ""
)